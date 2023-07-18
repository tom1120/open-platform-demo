package zhaoyi.librarian.web;

import com.axelor.auth.db.User;
import com.axelor.rpc.ActionRequest;
import com.axelor.rpc.ActionResponse;
import com.google.inject.Inject;
import zhaoyi.librarian.db.Reader;
import zhaoyi.librarian.db.repo.ReaderRepository;
import zhaoyi.librarian.service.ReaderService;

public class ReaderController {
    @Inject private ReaderRepository _readers;
    @Inject private ReaderService _readerService;

    public void onAssignUser(ActionRequest request, ActionResponse response){
        // 用 request 里 JSON 解析出来的 Map 字段名=>值 来填充对象 reader 里的对应属性
        Reader reader=request.getContext().asType(Reader.class);
        // 用 id 字段去数据库里查询 reader，返回 Hibernate 跟踪的实体类对象，
        // 后续操作一般是使用 Hibernate 跟踪的对象
        reader=_readers.find(reader.getId());
        if(reader.getUser()==null){
            User newUser=_readerService.assignNewUser(reader);
        }
        response.setFlash("赵义说：读者配套的登录用户设置好了");// 前端弹窗消息
        response.setReload(true);// 要求前端重新加载数据
    }
}
