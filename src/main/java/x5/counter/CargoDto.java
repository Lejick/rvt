package x5.counter;

import lombok.Builder;
import lombok.Data;

import java.util.List;

@Builder
@Data
public class CargoDto {
    private List<ProductValueDto> productValues;
}
