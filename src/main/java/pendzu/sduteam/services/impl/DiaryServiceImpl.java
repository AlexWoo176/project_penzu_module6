package pendzu.sduteam.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import pendzu.sduteam.models.Diary;
import pendzu.sduteam.repositories.IDiaryRepository;
import pendzu.sduteam.services.IDiaryService;

import java.util.Optional;

@Service
@PropertySource({"classpath:status.properties"})
public class DiaryServiceImpl implements IDiaryService {

    @Value("${entity.deleted}")
    private int deleteStatus;

    @Autowired
    private IDiaryRepository diaryRepository;

    @Override
    public Optional<Diary> findById(Long id) {
        return diaryRepository.findById(id);
    }

    @Override
    public Iterable<Diary> findAll() {
        return diaryRepository.findAll();
    }

    @Override
    public Diary save(Diary diary) {
        return diaryRepository.save(diary);
    }

    @Override
    public Diary create(Diary diary) {
        return diaryRepository.save(diary);
    }

    @Override
    public Page<Diary> findAll(Pageable pageable) {
        return diaryRepository.findAll(pageable);
    }

    @Override
    public Page<Diary> findAllByUserIdAndStatus(Pageable pageable, Long id, int status) {
        return diaryRepository.findAllByUserIdAndStatus(pageable, id, status);
    }

    @Override
    public void delete(Long id) {
        diaryRepository.deleteById(id);
    }

    @Override
    public void changeStatus(Long id) {
        Optional<Diary> diaryOptional = diaryRepository.findById(id);
        Diary diary = diaryOptional.get();
        if (diary != null) {
            diary.setStatus(deleteStatus);
            diaryRepository.save(diary);
        }
    }

    @Override
    public Iterable<Diary> findDiariesByUserId(Long user_id) {
        return diaryRepository.findDiariesByUserId(user_id);
    }

    @Override
    public Iterable<Diary> findDiariesByTagId(Long tag_id) {
        return diaryRepository.findDiariesByTagId(tag_id);
    }

    @Override
    public Iterable<Diary> findDiariesByTitleContaining(String title) {
        return diaryRepository.findDiariesByTitleContaining(title);
    }

    @Override
    public Page<Diary> findAllByOrderByCreatedateAsc(Pageable pageable) {
        return diaryRepository.findAllByOrderByCreatedateAsc(pageable);
    }

    @Override
    public Page<Diary> findAllByOrderByCreatedateDesc(Pageable pageable) {
        return diaryRepository.findAllByOrderByCreatedateDesc(pageable);
    }
}
