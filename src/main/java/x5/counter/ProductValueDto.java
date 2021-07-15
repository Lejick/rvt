package x5.counter;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@AllArgsConstructor
@Builder
public class ProductValueDto {
    Product product;
    Integer value;
}
