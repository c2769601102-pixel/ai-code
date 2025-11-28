package com.yupi.yuaicodemother.service;

import com.mybatisflex.core.paginate.Page;
import com.mybatisflex.core.query.QueryWrapper;
import com.mybatisflex.core.service.IService;
import com.yupi.yuaicodemother.model.dto.AppQueryRequest;
import com.yupi.yuaicodemother.model.entity.App;
import com.yupi.yuaicodemother.model.entity.User;
import com.yupi.yuaicodemother.model.vo.AppVO;
import com.yupi.yuaicodemother.model.vo.LoginUserVO;
import reactor.core.publisher.Flux;

import java.util.List;

/**
 * 应用 服务层。
 *
 * @author <a href="https://github.com/liyupi">程序员鱼皮</a>
 */
public interface AppService extends IService<App> {

    /**
     * 校验应用
     *
     * @param app 应用实体
     * @param add 是否为新增
     */
    void validApp(App app, boolean add);

    /**
     * 获取查询包装
     *
     * @param appQueryRequest 请求
     * @return wrapper
     */
    QueryWrapper getQueryWrapper(AppQueryRequest appQueryRequest);

    /**
     * 获取应用视图
     *
     * @param app 应用实体
     * @return 视图
     */
    AppVO getAppVO(App app);

    /**
     * 列表视图
     *
     * @param appList 实体列表
     * @return 视图列表
     */
    List<AppVO> getAppVOList(List<App> appList);

    /**
     * 根据 appId 与 message 生成ai代码
     * @param appId
     * @param message
     * @param loginUser
     * @return
     */
    public Flux<String> chatToGenCode(Long appId, String message, User loginUser);

    /**
     * 部署 app
     * @param appId
     * @param loginUser
     * @return
     */
    public String deployApp(Long appId, User loginUser);
}
