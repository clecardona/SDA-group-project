
package backend.file;
        import backend.user.User;

        import org.springframework.data.jpa.repository.JpaRepository;
        import org.springframework.stereotype.Repository;

        import java.util.Dictionary;
        import java.util.List;
        import java.util.Optional;

@Repository
public interface PictureRepository extends JpaRepository<Picture, Long> {


/*
    static Optional<FileDB> findById(Long id) {
        return null;
    }*/
}


