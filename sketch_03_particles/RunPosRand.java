class RunPosRand implements IRun {

  Vec center;
  float diameter;

  public RunPosRand(Vec center, float diameter) {
    this.center = center;
    this.diameter = diameter;
  }

  public RunPosRand(float x, float y, float diameter) {
    this(new Vec(x, y), diameter);
  }

  public void run(IParticle p) {
    float x = this.center.x() + App.get().random(-this.diameter/2, this.diameter/2);
    float y = this.center.y() + App.get().random(-this.diameter/2, this.diameter/2);
    p.setPos(new Vec(x, y));
  }

}
