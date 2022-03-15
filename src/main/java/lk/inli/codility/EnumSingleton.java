package lk.inli.codility;

public enum EnumSingleton {
  INSTANCE("Initial enum info");
  String info;

  EnumSingleton(String info) {
    this.info = info;
  }

  public EnumSingleton getInstance() {
    return INSTANCE;
  }

  public String getInfo() {
    return info;
  }

  public void setInfo(String info) {
    this.info = info;
  }
}
