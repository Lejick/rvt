package x5;

import lombok.Builder;
import lombok.Data;

import java.util.List;

@Builder
@Data
public class CargoDto {
    private List<ProductValueDto> productValues;
}
