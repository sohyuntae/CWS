import Box from "@mui/material/Box";
import Typography from "@mui/material/Typography";
import Divider from "@mui/material/Divider";
import List from "@mui/material/List";
import ListItem from "@mui/material/ListItem";
import ListItemText from "@mui/material/ListItemText";
import ListItemButton from "@mui/material/ListItemButton";

import iMenu from "../assets/interfaces/iMenu";
import MuiDrawer from "@mui/material/Drawer";

import { Link } from "react-router-dom";

const drawerWidth = 240;

interface Props {
  window?: () => Window;
  menus: Array<iMenu>;
  mobileOpen: boolean;
  handleDrawerToggle: () => void;
}

function Drawer(props: Props) {
  const { window, menus, mobileOpen, handleDrawerToggle } = props;

  const drawer = (
    <Box onClick={handleDrawerToggle} sx={{ textAlign: "center" }}>
      <Typography variant="h6" sx={{ my: 2 }}>
        <Link to="/">CWS</Link>
      </Typography>
      <Divider />
      <List>
        {menus.map((menu, index) => (
          <Link to={menu.link} key={index}>
            <ListItem key={menu.name} disablePadding>
              <ListItemButton sx={{ textAlign: "center" }}>
                <ListItemText primary={menu.name} />
              </ListItemButton>
            </ListItem>
          </Link>
        ))}
      </List>
    </Box>
  );

  const container = window !== undefined ? () => window().document.body : undefined;

  return (
    <MuiDrawer
      container={container}
      variant="temporary"
      open={mobileOpen}
      onClose={handleDrawerToggle}
      ModalProps={{
        keepMounted: true, // Better open performance on mobile.
      }}
      sx={{
        display: { xs: "block", sm: "none" },
        "& .MuiDrawer-paper": {
          boxSizing: "border-box",
          width: drawerWidth,
        },
      }}
    >
      {drawer}
    </MuiDrawer>
  );
}

export default Drawer;
