package br.com.mspedidos.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "pedidos")
@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
@JsonIgnoreProperties(ignoreUnknown=true)
public class Pedidos {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "data_registro")
    @CreationTimestamp
    private LocalDateTime dataRegistro;

    @Column(name = "id_cliente")
    private Long idCliente;

    @Column(name = "valor_total")
    private float valorTotal;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name="pedido_id")
    private List<ItemsPedido> items;
}
