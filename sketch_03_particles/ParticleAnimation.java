import java.util.List;

abstract class ParticleAnimation {

  abstract List<ISpawnerGroup> getGroups();

  public void update() {
    for(ISpawnerGroup group: this.getGroups())
      group.update();
  }

  public void draw() {
    for(ISpawnerGroup group: this.getGroups())
      group.draw();
  }

}

