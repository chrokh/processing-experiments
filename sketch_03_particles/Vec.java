import processing.core.PVector;

class Vec {

  PVector v;

  public Vec(double x, double y) {
    this.v = new PVector((float)x, (float)y);
  }

  public Vec(float x, float y) {
    this.v = new PVector(x, y);
  }

  protected Vec(PVector v) {
    this.v = v;
  }

  protected PVector raw() {
    return v;
  }

  public float y() {
    return this.v.y;
  }

  public float x() {
    return this.v.x;
  }

  public Vec mult(Vec other) {
    return new Vec(this.v.mult(other.raw(), 1));
  }

  public Vec add(Vec other) {
    return new Vec(this.v.add(other.raw()));
  }

}
