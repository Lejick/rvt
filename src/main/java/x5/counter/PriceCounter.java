package x5.counter;

import org.junit.Test;

import java.math.BigDecimal;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class PriceCounter {
    @Test
    public void test1() {
        assertEquals(BigDecimal.ONE, sumCount(new CargoDto(List.of(new ProductValueDto(new Product(new Price(BigDecimal.ONE)), 1)))));
        assertEquals(new BigDecimal("2"), sumCount(new CargoDto(List.of(new ProductValueDto(new Product(new Price(BigDecimal.ONE)), 2)))));
        assertEquals(new BigDecimal("3"), sumCount(new CargoDto(List.of(new ProductValueDto(new Product(new Price(BigDecimal.ONE)), 1),
                new ProductValueDto(new Product(new Price(BigDecimal.ONE)), 2)))));
    }

    private BigDecimal sumCount(CargoDto cargoDto) {
        BigDecimal orderSum = BigDecimal.ZERO;
        List<ProductValueDto> productsValue = cargoDto.getProductValues();
        for (ProductValueDto productValueDto : productsValue) {
            BigDecimal productSum =
                    productValueDto
                            .getProduct()
                            .getPrice()
                            .getValue()
                            .multiply(BigDecimal.valueOf(productValueDto.getValue()));
            orderSum = orderSum.add(productSum);
        }
        return orderSum;
    }


    @Test
    public void test2() {
        assertEquals(BigDecimal.ONE, sumCount2(new CargoDto(List.of(new ProductValueDto(new Product(new Price(BigDecimal.ONE)), 1)))));
        assertEquals(new BigDecimal("2"), sumCount2(new CargoDto(List.of(new ProductValueDto(new Product(new Price(BigDecimal.ONE)), 2)))));
        assertEquals(new BigDecimal("3"), sumCount2(new CargoDto(List.of(new ProductValueDto(new Product(new Price(BigDecimal.ONE)), 1),
                new ProductValueDto(new Product(new Price(BigDecimal.ONE)), 2)))));
    }

    private BigDecimal sumCount2(CargoDto cargoDto) {
        return cargoDto.getProductValues().stream()
                .map(
                        p ->
                                p.getProduct()
                                        .getPrice()
                                        .getValue()
                                        .multiply(BigDecimal.valueOf(p.getValue())))
                .reduce(BigDecimal.ZERO, BigDecimal::add);
    }
}

