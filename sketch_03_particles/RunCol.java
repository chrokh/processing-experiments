class RunCol implements IRun{

  Color color;

  public RunCol(Color col) {
    this.color = col;
  }

  public RunCol(int col) {
    this.color = new Color(col);
  }

  public void run(IParticle p) {
    p.setCol(this.color);
  }

}

