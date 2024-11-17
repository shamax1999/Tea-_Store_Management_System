package edu.icet.dto;

import jakarta.persistence.Column;
import jakarta.persistence.Lob;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.format.annotation.NumberFormat;

import java.math.BigDecimal;
import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Item {
    private Integer itemId;

    private String itemName;
    private String teaType;
    private LocalDate manufactureDate;
    private LocalDate expireDate;

    @NumberFormat(pattern = "Rs.#,###.##")
    private BigDecimal price;

    private Integer quantity;
    private Integer adminId;
    private Integer managerId;

    @Lob
    @Column(name = "image_data", columnDefinition = "LONGBLOB")
    private byte[] imageData;

}
