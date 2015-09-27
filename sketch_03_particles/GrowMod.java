class GrowMod implements IMod {

  float strength = 1;

  public GrowMod() { }

  public GrowMod(float strength) {
    this.strength = strength;
  }

  public void mod(IParticle p) {
    float mult = this.strength;

    Vec size = p.getMag();
    size.x(size.x() * mult);
    size.y(size.x() * mult);

    p.setMag(size);
  }

}
