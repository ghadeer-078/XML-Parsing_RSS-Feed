package com.example.xml_parsing_rss_feed.Model

import org.simpleframework.xml.ElementList
import org.simpleframework.xml.Root
import java.io.Serializable


@Root(name = "feed", strict = false)
class Feed constructor() : Serializable {

    @field:ElementList(inline = true, name = "entry")
    var entries: List<Entry>? = null
}