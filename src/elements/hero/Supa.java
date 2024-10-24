package elements.hero;

import elements.value.Skills;
import elements.value.Stats;

import java.util.Arrays;
import java.util.List;

public interface Supa {
    String name = "SupaIdolSirKhaiGumonan";
    Stats stats = new Stats(6969,6969,-6969,1.0,1.0);
    List<Skills> skills = Arrays.asList(
            new Skills("Reality Warp",10,1),
            new Skills("Dimensional Shift",15,9),
            new Skills("Entropy Wave",20,7),
            new Skills("Void Embrace",25,5),
            new Skills("Ultimate Erasure",30,3)
    );
}
