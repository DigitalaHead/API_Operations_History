package ru.netology.MihailMokhov.domain.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import ru.netology.MihailMokhov.domain.Customer;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CustomerDTO {
    private Integer id;
    private String name;

    public static CustomerDTO fromCustomerDTO(Customer customer) {
        return new CustomerDTO(customer.getId(), customer.getName());
    }
}
