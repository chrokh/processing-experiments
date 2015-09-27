class Color {

  public int r, g, b, a;

  public Color(int c) {
    this(c, c, c, 255);
  }

  public Color(int r, int g, int b) {
    this(r, g, b, 255);
  }

  public Color(int r, int g, int b, int a) {
    this.r = r;
    this.g = g;
    this.b = b;
    this.a = a;
  }

  public int toInt() {
    return App.get().color(r, g, b, a);
  }
}
