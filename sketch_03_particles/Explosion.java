import java.util.ArrayList;
import java.util.List;


class Explosion extends ParticleAnimation {

  List<ISpawnerGroup> groups = new ArrayList<ISpawnerGroup>();

  public Explosion() {
    _addGroup(_trailingSmokeSpawners());
    _addGroup(_pieceSpawners());
    _addGroup(_smokeSpawners());
  }

  public List<ISpawner> _trailingSmokeSpawners() {
    List<ISpawner> spawners = new ArrayList<ISpawner>();
    int trailingSmokeCount = 1;
    for(int i=0; i<9; i++)
      spawners.add(new TrailingSmoke());
    return spawners;
  }

  public List<ISpawner> _pieceSpawners() {
    List<ISpawner> spawners = new ArrayList<ISpawner>();
    int pieceCount = (int)App.get().random(3, 12);
    for(int i=0; i<pieceCount; i++)
      spawners.add(new PieceSpawner(3));
    return spawners;
  }

  public List<ISpawner> _smokeSpawners() {
    List<ISpawner> spawners = new ArrayList<ISpawner>();
    int numSpawners = 40;
    int numSpawned  = 4;
    for(int i=0; i<numSpawners; i++)
      spawners.add(new SmokeSpawner(numSpawned));
    return spawners;
  }

  public void _addGroup(List<ISpawner> spawners) {
    ISpawnerGroup group = new SpawnerGroup(spawners);
    this.groups.add(group);
  }

  public List<ISpawnerGroup> getGroups() {
    return groups;
  }
}
