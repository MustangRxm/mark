/**
 * Created by m1 on 17-3-2.
 */
import {Card, CardActions, CardHeader, CardMedia, CardTitle, CardText} from "material-ui/Card";
import FlatButton from "material-ui/FlatButton";
import React from "react";
import FontIcon from "material-ui/FontIcon";
import "../css/IconStyle.css";
import {indigo100, grey700} from "material-ui/styles/colors";
import Chip from "material-ui/Chip";
import injectTapEventPlugin from "react-tap-event-plugin";
injectTapEventPlugin();
// const subTitle = ()=>(
//   <div>
//     <a href="#">test</a>
//   </div>
// );


const iconStyles = {
  // marginRight: 24,

  fontSize: '18px'
};
const style = {
  display: 'flex',
  alignItems: 'center',
  marginRight: 10
};
const tagStyle = {
  display: 'flex',
  alignItems: 'center',
  marginRight: 10,
  height: 14
};
const tagFontStyle = {
  color: '#ffffff'
};
const SubTitle = React.createClass({
  render: function () {
    return <div>
      <div style={style}>
        <div style={style}>
          <FontIcon className="material-icons md-light  md-48"
                    style={iconStyles}>date_range</FontIcon>
          <p>{this.props.createDatetime}</p>
        </div>
        <div style={style}>
          <FontIcon className="material-icons md-light  md-48"
                    style={iconStyles}>account_circle</FontIcon>
          <p>{this.props.author}</p>
        </div>
        <div style={style}>
          <FontIcon className="material-icons md-light  md-48"
                    style={iconStyles}>view_list</FontIcon>
          <p>{this.props.category}</p>
        </div>
      </div>
      <div style={style}>
        <FontIcon className="material-icons md-light  md-48" style={{
          fontSize: '18px',
          marginRight: 5
        }}>label</FontIcon>
        {this.props.tagList.map(function (item,i) {
          return <Chip key={i} backgroundColor={indigo100} style={tagStyle
          }><p style={tagFontStyle}>{item}</p></Chip>
        })}
        {/*<Chip backgroundColor={indigo100} style={tagStyle*/}
        {/*}><p style={tagFontStyle}>66666</p></Chip>*/}
        {/*<Chip backgroundColor={indigo100} style={tagStyle*/}
        {/*}><p style={tagFontStyle}>66666</p></Chip>*/}
      </div>
    </div>
      ;
  }
});

export default class CardItem extends React.Component {
  constructor(props) {
    super(props);
    this.state = {
      expanded: true,
    };
  }

  handleExpandChange = (expanded) => {
    // console.log('test ' + expanded);
    this.setState({expanded: expanded});
  };
  // handleToggle = (event, toggle) => {
  //   console.log('test ' + toggle);
  //   this.setState({expanded: toggle});
  // };
  handleExpand = () => {
    // console.log('onhandleExpand');
    this.setState({expanded: !this.state.expanded});
  };

  render() {
    return (
      <Card expanded={this.state.expanded} onExpandChange={this.handleExpandChange}>
        <CardTitle
          title={this.props.title} subtitle={
            <SubTitle author={this.props.author}
            createDatetime={this.props.createDatetime}
                      category={this.props.category}
                      tagList={this.props.tagList}
            />}
        />
        <CardText expandable={true} >{this.props.text}
        </CardText>
        <CardActions style={{
          display: 'flex',
          alignItems: 'center',
          justifyContent: 'flex-end'
        }}>
          <FlatButton icon={
            <FontIcon className="material-icons md-light  md-48" style={iconStyles}>
            library_books</FontIcon>
          } label="Read All" style={{color: grey700}} onTouchTap={this.handleExpand}/>
        </CardActions>
      </Card>
    );
  }
}
