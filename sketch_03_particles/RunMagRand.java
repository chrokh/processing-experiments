class RunMagRand implements IRun{

  float min;
  float max;

  public RunMagRand(float min, float max) {
    this.min = min;
    this.max = max;
  }

  public void run(IParticle p) {
    float x = App.get().random(this.min, this.max);
    float y = App.get().random(this.min, this.max);
    p.setMag(new Vec(x, y));
  }

}
