import processing.core.PApplet;

class App {
  static PApplet app;

  public static void set(PApplet app) {
    App.app = app;
  }

  public static PApplet get() {
    return App.app;
  }
}

