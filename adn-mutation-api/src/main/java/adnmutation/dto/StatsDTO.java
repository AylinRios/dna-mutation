package adnmutation.dto;

import lombok.Builder;
import lombok.Value;

import java.io.Serializable;

@Builder
@Value
public class StatsDTO implements Serializable {

    private float count_mutations;
    private float count_not_mutation;
    private float ratio;

    public static StatsDTO build(float countMutations, float countNotMutation, float ratio){
        return StatsDTO.builder().count_mutations(countMutations).count_not_mutation(countNotMutation).ratio(ratio).build();

    }


}
