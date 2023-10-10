import * as React from 'react';
import PropTypes from 'prop-types';
import Tabs from '@mui/material/Tabs';
import Tab from '@mui/material/Tab';
import Typography from '@mui/material/Typography';
import Box from '@mui/material/Box';
import { MyRecipes } from './Myrecipes';
import { FavoriteRecipes } from './Favorites';
import { Drafts } from './Drafts';

function CustomTabPanel(props) {
    const { children, value, index, ...other } = props;
  
    return (
      <div
        role="tabpanel"
        hidden={value !== index}
        id={`simple-tabpanel-${index}`}
        aria-labelledby={`simple-tab-${index}`}
        {...other}
      >
        {value === index && (
          <Box sx={{ p: 3 }}>
            <Typography>{children}</Typography>
          </Box>
        )}
      </div>
    );
  }

CustomTabPanel.propTypes = {
  children: PropTypes.node,
  index: PropTypes.number.isRequired,
  value: PropTypes.number.isRequired,
};

function a11yProps(index) {
  return {
    id: `simple-tab-${index}`,
    'aria-controls': `simple-tabpanel-${index}`,
  };
}

export const RecipeTabs = (props) => {
  const [value, setValue] = React.useState(0);
  const { user } = props;
  const handleChange = (event, newValue) => {
    setValue(newValue);
  };

  return (
    <Box sx={{ width: '100%' }}>
      <Box sx={{ borderBottom: 1, borderColor: 'divider'}}>
        <Tabs value={value} onChange={handleChange} aria-label="basic tabs example" centered>
          <Tab label="Tus recetas" {...a11yProps(0)} />
          <Tab label="Tus favoritos" {...a11yProps(1)} />
          <Tab label="Borradores" {...a11yProps(2)} />
        </Tabs>
      </Box>
      <CustomTabPanel value={value} index={0}>
        <MyRecipes user={user} />
      </CustomTabPanel>
      <CustomTabPanel value={value} index={1}>
        <FavoriteRecipes user={user} />
      </CustomTabPanel>
      <CustomTabPanel value={value} index={2}>
        <Drafts />
      </CustomTabPanel>
    </Box>
  );
}