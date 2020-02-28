package com.skc.adminweb.ifs;

import com.skc.adminweb.model.network.Header;

public interface CurdInterface {

    Header create();

    Header read(Long id);

    Header update();

    Header delete(Long id);

}
