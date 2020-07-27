package pendzu.sduteam.models;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "diaries")
public class Diary {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    @NotBlank
    @Lob
    private String title;

    @NotBlank
    @Lob
    private String description;

    @Lob
    private String urlFile;

    @NotBlank
    @Lob
    private String content;

//    @NotBlank
    @ManyToOne(targetEntity = Tag.class)
    @JoinColumn(name = "tag_id")
    private Tag tag;

    private LocalDateTime createdate = LocalDateTime.now();

    private LocalDateTime updatedate;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "diaries_attachment",
            joinColumns = @JoinColumn(name = "diaries_id"),
            inverseJoinColumns = @JoinColumn(name = "attachments_id"))
    private Set<Attachment> attachment = new HashSet<>();


    private int status = 1;

    @ManyToOne(targetEntity = User.class)
    @JoinColumn(name = "users_id")
    private User user;


    private String blobString;

    @ManyToOne(targetEntity = Reaction.class)
    @JoinColumn(name = "reactions_id")
    private Reaction reaction;

    public Diary() {
    }


    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

//    public Diary(@NotBlank @Size(min = 3, max = 64) String title, @NotBlank @Size(min = 3, max = 64) String description, @NotBlank String content, @NotBlank Tag tag, LocalDateTime createdate, LocalDateTime updatedate, Set<Attachment> attachment, int status, User user, String blobString, Reaction reaction) {
//        this.title = title;
//        this.description = description;
//        this.content = content;
//        this.tag = tag;
//        this.createdate = createdate;
//        this.updatedate = updatedate;
//        this.attachment = attachment;
//        this.status = status;
//        this.user = user;
//        this.blobString = blobString;
//        this.reaction = reaction;
//    }

    public Diary(Long id, @NotBlank String title, @NotBlank String description, String urlFile, @NotBlank String content, Tag tag, LocalDateTime createdate, LocalDateTime updatedate, Set<Attachment> attachment, int status, User user, Reaction reaction) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.urlFile = urlFile;
        this.content = content;
        this.tag = tag;
        this.createdate = createdate;
        this.updatedate = updatedate;
        this.attachment = attachment;
        this.status = status;
        this.user = user;
        this.reaction = reaction;
    }

    public Diary(Long id, Tag tag, User user, String blobString, Reaction reaction) {
        this.id = id;
        this.tag = tag;
        this.user = user;
        this.blobString = blobString;
        this.reaction = reaction;
    }

    //    public Diary(String title, String description, String content,
//                 Tag tag, Set<Attachment> attachment, User user) {
//        this.title = title;
//        this.description = description;
//        this.content = content;
//        this.tag = tag;
//        this.attachment = attachment;
//        this.user = user;
//        this.blobstring = blobstring;
//    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Tag getTag() {
        return tag;
    }

    public void setTag(Tag tag) {
        this.tag = tag;
    }

    public LocalDateTime getCreatedate() {
        return createdate;
    }

    public void setCreatedate(LocalDateTime createdate) {
        this.createdate = createdate;
    }

    public LocalDateTime getUpdatedate() {
        return updatedate;
    }

    public void setUpdatedate(LocalDateTime updatedate) {
        this.updatedate = updatedate;
    }

    public Set<Attachment> getAttachment() {
        return attachment;
    }

    public void setAttachment(Set<Attachment> attachment) {
        this.attachment = attachment;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getUrlFile() {
        return urlFile;
    }

    public void setUrlFile(String urlFile) {
        this.urlFile = urlFile;
    }

    public String getBlobString() {
        return blobString;
    }

    public void setBlobString(String blobString) {
        this.blobString = blobString;
    }

    public Reaction getReaction() {
        return reaction;
    }

    public void setReaction(Reaction reaction) {
        this.reaction = reaction;
    }
}
