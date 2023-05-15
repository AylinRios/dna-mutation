package adnmutation.json;

import lombok.Builder;
import lombok.Value;
import java.io.Serializable;
import java.util.List;

@Builder
@Value
public class DnaBuild  implements Serializable {
    private List<List<String>> dna;

    public static DnaBuild build(List<List<String>> adn){
        return DnaBuild.builder().dna(adn).build();

    }
}
