import java.util.ArrayList;
import java.util.List;

class SpawnerGroup implements ISpawnerGroup {

  List<ISpawner> spawners;
  List<IParticle> particles = new ArrayList<IParticle>();

  public SpawnerGroup() {  }
  public SpawnerGroup(List<ISpawner> spawners) {
    this.spawners = spawners;
  }

  public void addSpawner(ISpawner spawner) {
    this.spawners.add(spawner);
  }

  public void update() {
    for(ISpawner s : this.spawners)
      if(s.canSpawn()){
        this.particles.add(s.spawn());
      }

    for(IParticle p : this.particles)
      p.update();
  }

  public void draw() {
    for(IParticle p : this.particles)
      p.draw();
  }
}
