package project.model.accounting;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import project.model.tour.Tour;

import javax.persistence.*;

/**
 * Created by slava23 on 12/10/2016.
 */

@Entity
@Data
@NoArgsConstructor
@RequiredArgsConstructor(staticName = "of")
public class Accounting {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @OneToOne
    @NonNull
    private Tour tour;
    @NonNull
    private String tpaNumber;
    @NonNull
    private String tpgNumber;
    @NonNull
    private String tourOperatorNumber;
    @NonNull
    private boolean isDirectPayment;
    private boolean electronicAct;
    private boolean paperAct;
}
