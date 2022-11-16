package rs.ftn.uns.btb.model.dto;

import lombok.Getter;
import lombok.Setter;

public class SearchCenterDTO {

    @Getter @Setter
    private Long id;
    @Getter @Setter
    private String name;
    @Getter @Setter
    private String address;
    @Getter @Setter
    private Double grade;

    public SearchCenterDTO(){}

    public SearchCenterDTO(String name, String address, Double grade){
        this.name = name;
        this.address = address;
        this.grade = grade;
    }

    public void copyValuesFromDTO(SearchCenterDTO searchCenterDTO) {
    }
}
