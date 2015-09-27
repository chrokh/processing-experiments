class GravityMod implements IMod {

  public void mod(IParticle p) {
    Vec vel = p.getVel();
    vel.y(vel.y() + 0.02f);
    p.setVel(vel);
  }

}
