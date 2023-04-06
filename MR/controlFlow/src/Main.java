/*
        ctrl+alt+l -> reformat code
        ctrl+d - copy current line to next line
        ctrl+shift+arrow up / down - move selected code line up / down
        shift+alt+mouse - multi-line coursor
*/
public class Main {
    public static void main(String[] args) {
        int ageLukas = 20;
        int ageDavid = 30;

        boolean isOld = ageDavid > 20 && ageLukas > 20;
        if (isOld){
            System.out.println("We are old");
        } else {
            System.out.println("We are young");
        }
        System.out.println("----------");
        System.out.println("Pocitanie veku");
        System.out.println("----------");
        System.out.println(++ageLukas);
        System.out.println(ageLukas++);
        System.out.println(ageLukas);
    }

}