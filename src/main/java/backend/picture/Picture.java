/*
package backend.picture;
import backend.user.User;

        import javax.persistence.*;
        import javax.validation.constraints.NotBlank;

@Entity
public class Picture {
    //fields
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column
    private long id;

    @NotBlank
    @Column(nullable = false)
    private String name;

    @NotBlank
    @Column(nullable = false)
    private String type;
    @NotBlank
    @Column(nullable = false)
    private String likes;

    @ManyToOne (targetEntity = User.class, cascade = CascadeType.ALL)
    private User pictureOwner;

    @Lob
    private byte[] data;

    //constructors

    public Picture() {
    }

    public Picture(@NotBlank String name, @NotBlank String type, byte[] data, String like) {
        this.name = name;
        this.type = type;
        this.data = data;
        this.likes = like;
    }

    //getters and setters

    public User getPictureOwner() {
        return pictureOwner;
    }

    public void setPictureOwner(User pictureOwner) {
        this.pictureOwner = pictureOwner;
    }
    public Long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public byte[] getData() {
        return data;
    }

    public void setData(byte[] data) {
        this.data = data;
    }

    public String getLikes() {
        return likes;
    }

    public void setLikes(String likes) {
        this.likes = likes;
    }
}
*/
