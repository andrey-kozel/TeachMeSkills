/*
 * Copyright (C) 2021 ReserveHub. All rights reserved.
 */

package com.example.groovy.service;

import java.util.List;

import com.example.groovy.dto.ConnectorType;

public interface StatsPublishService<T> {

  void publishMessages(final ConnectorType connectorType, final List<T> messages);

}
