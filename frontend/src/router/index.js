import Vue from 'vue'
import VueRouter from 'vue-router'
import LogInView from "@/views/LogInView";
import MainView from "@/views/MainView";
import NewInspectionView from "@/views/NewInspectionView";
import NewConstructionSiteView from "@/views/NewConstructionSiteView";
import NewReportView from "@/views/NewReportView";
import ReportOverviewView from "@/views/ReportOverviewView";
import InspectorAllTasksView from "@/views/InspectorAllTasksView";
import InspectorAllReportsView from "@/views/InspectorAllReportsView";
import NewTaskResponseView from "@/views/NewTaskResponseView";
import InspectorTaskResponseView from "@/views/InspectorTaskResponseView";

Vue.use(VueRouter)

const routes = [
    {
        path: '/',
        name: 'logInRoute',
        component: LogInView
    },
    {
        path: '/main',
        name: 'mainRoute',
        component: MainView
    },
    {
        path: '/inspection/sites',
        name: 'newInspectionRoute',
        component: NewInspectionView
    },
    {
        path: '/construction-site/new',
        name: 'newConstructionSiteRoute',
        component: NewConstructionSiteView
    },
    {
        path: '/report/new',
        name: 'newReportViewRoute',
        component: NewReportView
    },
    {
        path: '/report/overview',
        name: 'ReportOverviewRoute',
        component: ReportOverviewView
    },
    {
        path: '/inspector/alltasks',
        name: 'InspectorAllTasksView',
        component: InspectorAllTasksView
    },
    {
        path: '/inspector/allreports',
        name: 'InspectorAllReportsRoute',
        component: InspectorAllReportsView
    },
    {
        path: '/taskresponse/new',
        name: 'NewTaskResponseRoute',
        component: NewTaskResponseView
    },
    {
        path: '/inspector/alltasks/view',
        name: 'InspectorTaskResponseRoute',
        component: InspectorTaskResponseView
    }
]

const router = new VueRouter({
    routes
})

export default router
