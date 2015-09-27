class FadeMod implements IMod {

  int noise    = 1;
  int strength = 1;
  float chance = 1f;

  public FadeMod() { }

  public FadeMod(int strength) {
    this.strength = strength;
  }

  public FadeMod(int strength, float chance) {
    this.strength = strength;
    this.chance   = chance;
  }

  public void mod(IParticle p) {
    if(App.get().noise(this.noise++) < this.chance) {
      Color c = p.getCol();
      c.a -= strength;
      p.setCol(c);
    }
  }

}
