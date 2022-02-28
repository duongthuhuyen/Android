package api.API.Reposity;

import api.API.Model.Entity.Comment;
import api.API.orm.JpaRepository;

public interface CommentReposity extends JpaRepository<Comment,Integer> {
}
