package com.gfa.aliaser.models.dtos;

import com.gfa.aliaser.models.Alias;

public class AliasDTO {
    public final Long id;
    public final String url;
    public final String alias;
    public final int hitCount;

    public AliasDTO(Alias a) {
        id = a.getId();
        url = a.getUrl();
        alias = a.getAlias();
        hitCount = a.getHitCount();
    }
}
