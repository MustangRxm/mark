/**
 * Created by m1 on 17-2-28.
 */
import React from "react";
import AppBar from "material-ui/AppBar";
import MuiThemeProvider from 'material-ui/styles/MuiThemeProvider';
import ActionAndroid from "material-ui/svg-icons/action/android";
import FlatButton from "material-ui/FlatButton";

const MHeader = () => (


    <AppBar
      title="网站标题"
      iconClassNameRight="muidocs-icon-navigation-expand-more"
      style={{
        flexDirection: 'row',
        alignItems: 'center'
      }}
      className="appbar"
    >
      <FlatButton
        label="首页"
        labelPosition="after"
        primary={false}
        icon={<ActionAndroid />}
      />
      <FlatButton
        label="分类"
        labelPosition="after"
        primary={false}
        icon={<ActionAndroid />}
      />
      <FlatButton
        label="标签"
        labelPosition="after"
        primary={false}
        icon={<ActionAndroid />}
      />
      <FlatButton
        label="实验田"
        labelPosition="after"
        primary={false}
        icon={<ActionAndroid />}
      />
      <FlatButton
        label="关于我"
        labelPosition="after"
        primary={false}
        icon={<ActionAndroid />}
      />
    </AppBar>

);

export default MHeader;
