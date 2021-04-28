package backend.dislike;

import backend.file.FileDB;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIdentityReference;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

@Entity
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
public class DisLike {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    @Column(nullable = false)
    private String body;

    /*@NotBlank
    @Column(nullable = false)
    private String FileOwnerName;*/

    @ManyToOne
    @JsonIdentityReference(alwaysAsId=true)
    @JoinColumn(nullable = false)
    private FileDB fileDB;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

//    public String getFileOwnerName() {
//        return FileOwnerName;
//    }
//
//    public void setFileOwnerName(String fileOwnerName) {
//        FileOwnerName = fileOwnerName;
//    }

    public FileDB getFileDB() {
        return fileDB;
    }

    public void setFileDB(FileDB fileDB) {
        this.fileDB = fileDB;
    }
}
