/*
 * Copyright (C) 2011-2013 FocusSNS.
 *
 * This library is free software; you can redistribute it and/or
 * modify it under the terms of the GNU Lesser General Public
 * License as published by the Free Software Foundation; either
 * version 2.1 of the License, or (at your option) any later version.
 *
 * This library is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU
 * Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public
 * License along with this library; if not, write to the Free Software
 * Foundation, Inc., 51 Franklin Street, Fifth Floor, Boston,
 * MA 02110-1301  USA
 */
package org.focusns.service.core.impl;

import org.focusns.dao.core.ProjectDao;
import org.focusns.dao.core.ProjectHistoryDao;
import org.focusns.dao.core.ProjectUserDao;
import org.focusns.model.common.Page;
import org.focusns.model.core.ProjectHistory;
import org.focusns.service.core.ProjectHistoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

@Service
@Transactional
public class ProjectHistoryServiceImpl implements ProjectHistoryService {

    @Autowired
    private ProjectUserDao projectUserDao;
    @Autowired
    private ProjectDao projectDao;
    @Autowired
    private ProjectHistoryDao projectHistoryDao;
    
    public void createProjectHistory(ProjectHistory histroy) {
        //
        Date now = new Date();
        histroy.setCreateAt(now);
        //
        projectHistoryDao.insert(histroy);
    }

    public void modifyProjectHistory(ProjectHistory history) {
        projectHistoryDao.update(history);
    }

    public void removeProjectHistory(ProjectHistory history) {
        projectHistoryDao.delete(history.getId());
    }

    public Page<ProjectHistory> fetchPage(Page<ProjectHistory> page, long projectId) {
        page = projectHistoryDao.fetchByProjectId(page, projectId);
        //
        for(ProjectHistory history : page.getResults()) {
            List<ProjectHistory> children = projectHistoryDao
                    .selectByParentId(history.getId());
            history.setChildren(children);
        }
        //
        return page;
    }
    
}