package Keyword.likes.controller;

import Keyword.likes.domain.LikesVO;
import Keyword.likes.service.LikesService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.inject.Inject;
import java.util.List;

@Controller
@RequestMapping("/likes")
public class likesController {
    private final LikesService likesService;

    @Inject
    public likesController(LikesService likesService) {
        this.likesService = likesService;
    }

    // 좋아요 등록
    @RequestMapping(value = "", method = RequestMethod.POST)
    public ResponseEntity<String> liked(@RequestBody LikesVO likesVO){
        ResponseEntity<String> entity = null;
        try{
            likesService.liked(likesVO);
            entity = new ResponseEntity<>("regSuccess", HttpStatus.OK);
        } catch (Exception e){
            e.printStackTrace();
            entity = new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
        return entity;
    }

    // 좋아요 삭제
    @RequestMapping(value = "", method = RequestMethod.DELETE)
    public ResponseEntity<String> unliked(@RequestBody LikesVO likesVO){
        ResponseEntity<String> entity = null;
        try{
            likesService.unliked(likesVO);
            entity = new ResponseEntity<>("delSuccess", HttpStatus.OK);
        } catch (Exception e){
            e.printStackTrace();
            entity = new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
        return entity;
    }

    // 좋아요 확인
    @RequestMapping(value = "", method = RequestMethod.GET)
    public ResponseEntity<LikesVO> isLiked(@RequestParam("contentId") String contentId,
                                          @RequestParam("userId") String userId){
        ResponseEntity<LikesVO> entity = null;
        try{
            entity = new ResponseEntity<>(likesService.isLiked(contentId, userId), HttpStatus.OK);
        } catch (Exception e){
            e.printStackTrace();
            entity = new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        return entity;
    }
}
