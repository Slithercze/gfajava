import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class Main {
  public static void main(String[] args) {
    String inputDirectory = "assets/csv/";
    String inputFile = "countries.csv";
    String outputDirectory = "assets/html/";
    String templatePath = "assets/template.html";
    // !! načtu si data ze souboru
    // 1. mám to kam ukládat? Když složka html neexistuje, vytvořím si ji.
    createSaveDirectory(outputDirectory);

    // 2. načíst csv a vytvořit z něj html tabulku
    String htmlTable = "";
    try {
      htmlTable = parseCsvToHTMLTable(inputDirectory + inputFile);
    } catch (IOException e) {
      System.out.println("Nepovedlo se vyrobit html tabulku.");
    }

    // 3. Načíst svoji šablonu
    String templateContent = "";
    try {
      templateContent = Files.readString(Path.of(templatePath));
    } catch (IOException e) {
      System.out.println("Nepovedlo se načíst šablonu pro tabulku.");
    }

    // !! udělám s tím magii v kódu
    // 4. zkombinovat šablonu s vytvořenou tabulkou
    String outputContent = insertHTMLTableToTemplate(htmlTable, templateContent);

    // 5. název pod kterým to uložím -> nazevSoubor.--csv-- -> html
    String outputName = getOutputName(inputFile);

    // !! uložím do souboru
    // 6. Zapsat co jsem vytvořil do outputDirectory pod vytvořeným názvem.
    try {
      saveFile(outputContent, outputDirectory + outputName);
    } catch (IOException e) {
      System.out.println("Nepodařilo se uložit soubor");
    }
  }

  private static void saveFile(String outputContent, String outputPath) throws IOException {
    Files.writeString(Path.of(outputPath), outputContent);
  }

  private static String getOutputName(String inputFile) {
    return inputFile.replace(".csv", ".html");
  }

  private static String insertHTMLTableToTemplate(String htmlTable, String templateContent) {
    int bodyStarIndex = templateContent.indexOf("<body>") + "<body>".length();
    int bodyEndIndex = templateContent.indexOf("</body>");

    return templateContent.substring(0, bodyStarIndex).concat("\n")
        .concat(htmlTable).concat("\n")
        .concat(templateContent.substring(bodyEndIndex));
  }

  private static String parseCsvToHTMLTable(String inputPath) throws IOException {
    List<String> lines = Files.readAllLines(Path.of(inputPath));
    StringBuilder htmlTable = new StringBuilder("<table class=\"table\">\n");

    for (int i = 0; i < lines.size(); i++) {
      String line = lines.get(i);
      if (i == 0) {
        htmlTable.append("<thead>\n");
        htmlTable.append(createHtmlHeaderRow(line));
        htmlTable.append("</thead>\n");
        htmlTable.append("<tbody>\n");
      } else {
        htmlTable.append(createHtmlDataRow(line));
      }
    }

    htmlTable.append("</tbody>\n</table>");
    return htmlTable.toString();
  }

  private static String createHtmlHeaderRow(String line) {
    return createHtmlRow(line, "th");
  }

  private static String createHtmlRow(String line, String cellType) {
    StringBuilder row = new StringBuilder("<tr>");
    String[] cells = line.split(",");

    for (String cell : cells) {
      row.append("<").append(cellType).append(">")
          .append(cell.trim())
          .append("</").append(cellType).append(">");
    }

    row.append("</tr>\n");
    return row.toString();
  }

  private static String createHtmlDataRow(String line) {
    return createHtmlRow(line, "td");
  }

  private static void createSaveDirectory(String outputDirectory) {
    try {
      Files.createDirectories(Path.of(outputDirectory));
    } catch (IOException exception) {
      System.out.println("Nepovedlo se vytvořit cílovou složku.");
    }
  }
}
