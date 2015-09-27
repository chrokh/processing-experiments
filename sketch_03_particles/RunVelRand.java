class RunVelRand implements IRun{

  private static int noise = 0;

  float max;

  public RunVelRand(float max) {
    this.max = max;
  }

  public void run(IParticle p) {
    float min = -this.max;
    float max = this.max*2;
    float x = min + App.get().noise(RunVelRand.nextNoise()) * max;
    float y = min + App.get().noise(RunVelRand.nextNoise()) * max;
    p.setVel(new Vec(x, y));
  }

  private static int nextNoise() {
    return RunVelRand.noise += 1;
  }
}
