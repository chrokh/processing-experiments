class GravityMod implements IMod {

  float strength = 1;

  public GravityMod() { }

  public GravityMod(float strength) {
    this.strength = strength;
  }

  public void mod(IParticle p) {
    float dec = 0.02f * strength;
    Vec vel = p.getVel();
    vel.y(vel.y() + dec);
    p.setVel(vel);
  }

}
