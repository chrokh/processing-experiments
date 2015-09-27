import java.util.ArrayList;
import java.util.List;


class Explosion extends ParticleAnimation {

  List<ISpawnerGroup> groups = new ArrayList<ISpawnerGroup>();

  public Explosion() {

    {
      int trailingSmokeCount = 1;
      List<ISpawner> spawners = new ArrayList<ISpawner>();
      for(int i=0; i<9; i++)
        spawners.add(new TrailingSmoke());
      ISpawnerGroup group = new SpawnerGroup(spawners);
      this.groups.add(group);
    }

    int numSpawners = 40;
    int numSpawned  = 4;
    for(int i=0; i<numSpawners; i++) {

      List<ISpawner> spawners = new ArrayList<ISpawner>();
      spawners.add(new SmokeSpawner(numSpawned));

      ISpawnerGroup group = new SpawnerGroup(spawners);

      this.groups.add(group);
    }

    int pieceCount = (int)App.get().random(3, 12);
    for(int i=0; i<pieceCount; i++) {
      List<ISpawner> spawners = new ArrayList<ISpawner>();
      spawners.add(new PieceSpawner(3));
      ISpawnerGroup group = new SpawnerGroup(spawners);
      this.groups.add(group);
    }
  }

  public List<ISpawnerGroup> getGroups() {
    return groups;
  }
}
