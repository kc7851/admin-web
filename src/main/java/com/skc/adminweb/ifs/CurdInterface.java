package com.skc.adminweb.ifs;

import com.skc.adminweb.model.network.Header;

public interface CurdInterface<Req, Res> {

    Header<Res> create(Header<Req> request);

    Header<Res> read(Long id);

    Header<Res> update(Header<Req> request);

    Header delete(Long id);

}
