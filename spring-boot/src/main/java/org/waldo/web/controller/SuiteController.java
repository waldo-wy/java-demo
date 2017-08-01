/**
 * @author waldo.wy
 * @date 2017/7/22
 */
package org.waldo.web.controller;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 类SuiteController描述：
 *
 * @author waldo.wangy 2017/7/22 16:50
 */
@RestController
@RequestMapping("/suite")
public class SuiteController {

    @RequestMapping("/{appId}/callback.sm")
    public String suiteVerify(@PathVariable String appId) {
        return appId;
    }

}
