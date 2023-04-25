package mentors;

public enum MentorLevel {
  JUNIOR("junior"),
  MEDIOR("medior"),
  SENIOR("senior");

  private String myName;

  MentorLevel(String myName) {
    this.myName = myName;
  }

  @Override
  public String toString() {
    return myName;
  }
}
