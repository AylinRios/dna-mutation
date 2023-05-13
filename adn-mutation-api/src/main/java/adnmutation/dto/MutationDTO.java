package adnmutation.dto;


import lombok.Data;
import java.util.Date;

@Data
public class MutationDTO {

    private String name;
    private Date createdAt;
    private boolean hasMutation;

}
