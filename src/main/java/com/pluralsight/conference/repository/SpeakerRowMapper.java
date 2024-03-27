package com.pluralsight.conference.repository;

import com.pluralsight.conference.model.Speaker;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class SpeakerRowMapper implements RowMapper<Speaker> {

    @Override
    public Speaker mapRow(ResultSet resultSet, int rowNum) throws SQLException {
        Speaker speaker = new Speaker();
        speaker.setId(resultSet.getInt("id"));
        speaker.setName(resultSet.getString("name"));
        return speaker;
    }
}
